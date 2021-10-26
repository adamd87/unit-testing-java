package pl.adamd.unit_tests.testing.account;

import java.util.List;

public interface AccountRepository {
    List<Account> getAllAccount();
    List<String> getByName(String name);
}
