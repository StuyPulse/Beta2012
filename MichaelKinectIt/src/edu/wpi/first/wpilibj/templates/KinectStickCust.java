package edu.wpi.first.wpilibj.templates;

import com.sun.cldc.jna.BlockingFunction;
import com.sun.cldc.jna.NativeLibrary;
import com.sun.cldc.jna.Pointer;
import com.sun.cldc.jna.Structure;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.communication.FRCControl;
import edu.wpi.first.wpilibj.communication.FRCControl.CachedNativeBuffer;
import edu.wpi.first.wpilibj.communication.FRCControl.DynamicControlData;

/**
 *
 * @author bradmiller
 */
public class KinectStickCust extends GenericHID {

    private final static byte kJoystickDataID = 24;
    private final static byte kJoystickDataSize = 18;
    static final byte kDefaultYAxis = 2;
    static final byte kDefaultZAxis = 3;
    static final byte kDefaultTwistAxis = 3;
    static final byte kDefaultThrottleAxis = 4;
    static final int kDefaultTriggerButton = 1;
    static final int kDefaultTopButton = 2;
    private int m_id;
    private static final CachedNativeBuffer controlDataCache = new CachedNativeBuffer();
    private static final BlockingFunction getDynamicControlDataFn = NativeLibrary.getDefaultInstance().getBlockingFunction("getDynamicControlData");

    static class JoystickDataBlock extends Structure {

        byte joystick1[] = new byte[6];
        short button1;
        byte joystick2[] = new byte[6];
        short button2;
        public static final int size = kJoystickDataSize - 2;

        JoystickDataBlock(Pointer backingMemory) {
            useMemory(backingMemory);
        }

        public void read() {
            backingNativeMemory.getBytes(0, joystick1, 0, 6);
            button1 = backingNativeMemory.getShort(6);
            backingNativeMemory.getBytes(8, joystick2, 0, 6);
            button2 = backingNativeMemory.getShort(14);
        }

        public void write() {
            backingNativeMemory.setBytes(0, joystick1, 0, 6);
            backingNativeMemory.setShort(6, button1);
            backingNativeMemory.setBytes(8, joystick2, 0, 6);
            backingNativeMemory.setShort(14, button2);
        }

        public int size() {
            return size;
        }
    }

    class JoystickData extends FRCControl.DynamicControlData {

        JoystickDataBlock data;

        {
            allocateMemory();
            data = new JoystickDataBlock(
                    new Pointer(backingNativeMemory.address().toUWord().toPrimitive() + 2,
                    JoystickDataBlock.size));
        }

        public void read() {
            data.read();
        }

        public void write() {
            data.write();
        }

        public int size() {
            return kJoystickDataSize;
        }

        public void copy(JoystickData dest) {
            write();
            Pointer.copyBytes(backingNativeMemory, 0, dest.backingNativeMemory, 0, size());
            dest.read();
        }
    }
    JoystickData tempOutputData = new JoystickData();

    public KinectStickCust(int id) {
        m_id = id;
    }

    private void getData() {
        int retVal = getDynamicControlData(kJoystickDataID, tempOutputData, tempOutputData.size(), 5);
        if (retVal != 0) {
            System.err.println("Bad retval: " + retVal);
        }
    }

    public double getX(Hand hand) {
        return 0;
    }

    private double normalize(byte rawValue) {
        if (rawValue >= 0) {
            return rawValue / 127.0;
        } else {
            return rawValue / 128.0;
        }
    }

    public double getY(Hand hand) {
        getData();

        if (m_id == 1) {
            return normalize(tempOutputData.data.joystick1[1]);
        } else {
            return normalize(tempOutputData.data.joystick2[1]);
        }
    }

    public double getZ(Hand hand) {
        return 0;
    }

    public double getTwist() {
        return 0;
    }

    public double getThrottle() {
        return 0;
    }

    public double getRawAxis(int which) {
        if (which == 2) {
            return getY();
        } else {
            return 0;
        }
    }

    public boolean getTrigger(Hand hand) {
        getData();
        return (tempOutputData.data.button1 & (short) kDefaultTriggerButton) != 0;
    }

    public boolean getTop(Hand hand) {
        getData();
        return (tempOutputData.data.button1 & (short) kDefaultTopButton) != 0;
    }

    public boolean getBumper(Hand hand) {
        getData();
        return (tempOutputData.data.button1 & (short) 4) != 0;
    }

    public boolean getRawButton(int button) {
        getData();
        return (tempOutputData.data.button1 & (short) (1 << (button - 1))) != 0;
    }

    public static int getDynamicControlData(byte type, DynamicControlData dynamicData, int maxLength, int wait_ms) {
        synchronized (controlDataCache) {
            dynamicData.write();
            int res = getDynamicControlDataFn.call4(type, dynamicData.getPointer(), maxLength, wait_ms);
            //if (res == 0) {
                dynamicData.read();
           // }
            return res;
        }
    }
}
