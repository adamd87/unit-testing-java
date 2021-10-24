package pl.adamd.unit_tests.testing;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

class OrderBackupExecutionOrderTest {
    @Test
    void callingBackupWithoutCreatingAFileFirstShouldThrowException(){
        //given
        OrderBackup orderBackup = new OrderBackup();
        //when
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }
}
