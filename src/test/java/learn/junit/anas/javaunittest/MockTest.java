package learn.junit.anas.javaunittest;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    void mockTest() {
        // Membuat mock object dari List menggunakan framework Mockito
        List<String> list = Mockito.mock(List.class);
        //framework Mockito untuk meniru objek yang sudah ada

        // Menentukan perilaku mock ketika get(0) dan get(100) dipanggil
        Mockito.when(list.get(0)).thenReturn("Wiwok");
        Mockito.when(list.get(100)).thenReturn("Detox");

        // Menampilkan hasil pemanggilan method get()
        System.out.println(list.get(0)); // Output: Wiwok
        System.out.println(list.get(2)); // Output: null (karena tidak di-set)
        System.out.println(list.get(100)); // Output: Detox

        // Verifikasi bahwa method get(0) hanya dipanggil satu kali jika lebih dari nilai yang ditentukan maka akan gagal testnya
        Mockito.verify(list, Mockito.times(1)).get(0);

    }
}
