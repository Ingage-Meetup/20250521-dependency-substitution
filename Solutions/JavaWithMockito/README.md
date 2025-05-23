# Java Solution with Mockito Mocks
This is a Java solution using [Mockito](https://site.mockito.org/) to implement mocks for the different dependencies in our unit tests.

Definitely explore the Mockito site to learn more about mocking, and the benefits of using a library like this versus implementing your own
mocks.

But in a nutshell, here are the benefits of using any mocking library:
- **Less Boilerplate:** Mocking libraries automatically generate mock objects, saving you from writing repetitive code.
- **Flexible Behavior:** Easily configure mocks to return specific values, throw exceptions, or verify method calls.
- **Readable Tests:** Test code is more concise and expressive, making intent clearer.
- **Advanced Features:** Support for argument matching, call order verification, and interaction verification.
- **Reduced Maintenance:** Changes to dependencies often require fewer updates to test code.
- **Community Support:** Well-maintained libraries are robust, documented, and widely used, reducing bugs in your tests.

Using a library like Mockito helps you focus on testing logic, not on maintaining hand-written test doubles.

## Example: Using Mockito Mocks in Unit Tests

Suppose you have a `UserService` that depends on a `UserRepository`. With Mockito, you can easily mock the repository:

```java
// Using Mockito
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class UserServiceTest {
    @Test
    void testFindUser() {
        UserRepository mockRepo = mock(UserRepository.class);
        when(mockRepo.findById(1)).thenReturn(new User(1, "Alice"));

        UserService service = new UserService(mockRepo);
        User user = service.findUser(1);

        assertEquals("Alice", user.getName());
        verify(mockRepo).findById(1);
    }
}
```

### Without a Mocking Library (Hand-written Fake)

If you were not using a mocking library, you’d have to write your own fake implementation:

```java
// Without Mockito
class FakeUserRepository implements UserRepository {
    @Override
    public User findById(int id) {
        if (id == 1) return new User(1, "Alice");
        return null;
    }
    // Implement other methods as needed...
}

class UserServiceTest {
    @Test
    void testFindUser() {
        UserRepository fakeRepo = new FakeUserRepository();

        UserService service = new UserService(fakeRepo);
        User user = service.findUser(1);

        assertEquals("Alice", user.getName());
        // No easy way to verify method calls or arguments
    }
}
```

**With Mockito,** you avoid writing boilerplate fakes and get powerful features like method verification and flexible stubbing.