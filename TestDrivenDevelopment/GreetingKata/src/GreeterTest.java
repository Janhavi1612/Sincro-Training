import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GreeterTest {
	Greeter greeter;

	@BeforeEach
	void setup() {
		greeter = new Greeter();
	}

	@Test
	void shouldReturnHelloName() {
		Assertions.assertEquals("Hello, Bob", greeter.greet("Bob"));
	}

	@Test
	void shouldReturnHellomyFriendForNullInput() {
		Assertions.assertEquals("Hello, my friend", greeter.greet(""));
	}

	@Test
	void shouldShoutBackForUppercaseName() {
		Assertions.assertEquals("HELLO JERRY!", greeter.greet("JERRY"));
	}

	@Test
	void shouldHandleTwoNameInput() {
		Assertions.assertEquals("Hello Jill and Jane.", greeter.greet(new String[] { "Jill", "Jane" }));
	}

	@Test
	void shouldHandleArbitraryNumberOfInputs() {
		Assertions.assertEquals("Hello, Amy, Brian, and Charlotte.",
				greeter.greet(new String[] { "Amy", "Brian", "Charlotte" }));
	}

	@Test
	void shouldHandleMixOfNormalAndShouting() {
		Assertions.assertEquals("Hello, Amy and Charlotte. AND HELLO BRIAN!",
				greeter.greet(new String[] { "Amy", "BRIAN", "Charlotte" }));
	}

	@Test
	void shouldSplitStringsByCommas() {
		Assertions.assertEquals("Hello, Bob, Charlie, and Dianne.",
				greeter.greet(new String[] { "Bob", "Charlie, Dianne" }));
	}
}
