package com.shotkin.david;

import com.shotkin.david.Reverse;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class ReverseTest {

	/**
	 * Reverse a null String
	 */
	@Test
	public void reverseNull() {
		Assert.assertEquals(Reverse.reverseEverything(null), null);
	}

	/**
	 * Reverse a single-character String
	 */
	@Test
	public void reverseCharacter() {
		Assert.assertEquals(Reverse.reverseEverything("a"), "a");
	}

	/**
	 * Reverse a multi-character String
	 */
	@Test
	public void reverseString() {
		Assert.assertEquals(Reverse.reverseEverything("hope you are doing well"), "llew gniod era uoy epoh");
	}
}
