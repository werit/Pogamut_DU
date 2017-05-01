package cz.cuni.amis.utils.flag;

import org.junit.Test;

import cz.cuni.amis.tests.BaseTest;


public class Test07_Flag extends BaseTest {
	
	/**
     * Not so good test of the flag - you need to confirm the results for yourself.
     */
	@Test
    public void test01() {
        final Flag<Boolean> flag = new Flag<Boolean>(true);
        
        FlagListenerMock<Boolean> fl1 = new FlagListenerMock<Boolean>();
        FlagListenerMock<Boolean> fl2 = new FlagListenerMock<Boolean>();
        FlagListenerMock<Boolean> fl3 = new FlagListenerMock<Boolean>();
        
        flag.addWeakListener(fl1);
        flag.setFlag(false);
        flag.setFlag(false);
        
        flag.addWeakListener(fl2);
        flag.setFlag(true);
        flag.setFlag(true);
        
        flag.addWeakListener(fl3);
        flag.setFlag(false);
        flag.setFlag(false);
        
        fl1.checkValuesInOrder("FlagListener1", new Boolean[]{ false, true, false });
        fl2.checkValuesInOrder("FlagListener2", new Boolean[]{true, false});
        fl3.checkValuesInOrder("FlagListener3", new Boolean[]{false});
        
        flag.removeListener(fl1);
        flag.setFlag(true);
        flag.setFlag(true);

        flag.removeListener(fl2);
        flag.setFlag(false);
        flag.setFlag(false);
        
        flag.removeListener(fl3);
        flag.setFlag(true);
        flag.setFlag(true);
        
        fl1.checkValuesInOrder("FlagListener1", new Boolean[0]);
        fl2.checkValuesInOrder("FlagListener2", new Boolean[]{true});
        fl3.checkValuesInOrder("FlagListener3", new Boolean[]{true,false});
        
        testOk();
    }
	
}
