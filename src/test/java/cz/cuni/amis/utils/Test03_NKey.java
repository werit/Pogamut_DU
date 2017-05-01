package cz.cuni.amis.utils;

import junit.framework.Assert;

import org.junit.Test;

import cz.cuni.amis.tests.BaseTest;

public class Test03_NKey extends BaseTest {

	/**
	 * Test method - checks whether key1.equals(key2) (or not equals according to 'equals' parameter).
	 * @param key1
	 * @param key2
	 * @param equals
	 */
	private static void testEquals(NKey key1, NKey key2, boolean equals) {
		if (equals) {
			log.info(key1 + " == " + key2 + " ?");
			Assert.assertTrue("NO! Failure...", key1.equals(key2));
		} else {
			log.info(key1 + " != " + key2 + " ?");
			Assert.assertTrue("NO! Failure...", !key1.equals(key2));
		}
		log.info("YES");
	}

	@Test
	public void test() {
		NKey key1 = new NKey(1,2);
		NKey key2 = new NKey(1,2,3);
		NKey key3 = new NKey(2,1);
		NKey key4 = new NKey(2,3,1);
		NKey key5 = new NKey(1,2,3,4);
		NKey key6 = new NKey(1,2,3,4);
		NKey key7 = new NKey(2,1,4,3);
		NKey key8 = new NKey(1,2,3,4,5);
                NKey key9 = null;
                NKey key10 = new NKey(null, null);
                NKey key11 = new NKey(null, null);
                
		testEquals(key1, key1, true);
		testEquals(key2, key2, true);
		testEquals(key3, key3, true);
		testEquals(key4, key4, true);
		testEquals(key5, key5, true);
		testEquals(key6, key6, true);
		testEquals(key7, key7, true);
		testEquals(key8, key8, true);
		testEquals(key1, key2, false);
		testEquals(key1, key3, false);
		testEquals(key1, key4, false);
		testEquals(key1, key5, false);
		testEquals(key1, key6, false);
		testEquals(key1, key7, false);
		testEquals(key1, key8, false);
		testEquals(key2, key1, false);
		testEquals(key2, key3, false);
		testEquals(key2, key4, false);
		testEquals(key2, key5, false);
		testEquals(key2, key6, false);
		testEquals(key2, key7, false);
		testEquals(key2, key8, false);
		testEquals(key3, key1, false);
		testEquals(key3, key2, false);
		testEquals(key3, key4, false);
		testEquals(key3, key5, false);
		testEquals(key3, key6, false);
		testEquals(key3, key7, false);
		testEquals(key3, key8, false);
		testEquals(key4, key1, false);
		testEquals(key4, key2, false);
		testEquals(key4, key3, false);
		testEquals(key4, key5, false);
		testEquals(key4, key6, false);
		testEquals(key4, key7, false);
		testEquals(key4, key8, false);
		testEquals(key5, key1, false);
		testEquals(key5, key2, false);
		testEquals(key5, key3, false);
		testEquals(key5, key4, false);
		testEquals(key5, key6, true);
		testEquals(key5, key7, false);
		testEquals(key5, key8, false);
		testEquals(key6, key1, false);
		testEquals(key6, key2, false);
		testEquals(key6, key3, false);
		testEquals(key6, key4, false);
		testEquals(key6, key5, true);
		testEquals(key6, key7, false);
		testEquals(key6, key8, false);
		testEquals(key7, key1, false);
		testEquals(key7, key2, false);
		testEquals(key7, key3, false);
		testEquals(key7, key4, false);
		testEquals(key7, key5, false);
		testEquals(key7, key6, false);
		testEquals(key7, key8, false);
		testEquals(key8, key1, false);
		testEquals(key8, key2, false);
		testEquals(key8, key3, false);
		testEquals(key8, key4, false);
		testEquals(key8, key5, false);
		testEquals(key8, key6, false);
		testEquals(key8, key7, false);
                try {
                    testEquals(key8, key9, false);
                } catch (NullPointerException ex) {
                    testFailed("NKey equals not resistant to null objects.. (NKey = null)");
                }
                try {
                    testEquals(key10, key11, true);
                } catch (NullPointerException ex) {
                    testFailed("NKey equals not resistant to null objects.. (NKey(null, null))");
                }		
		testOk();
	}



}
