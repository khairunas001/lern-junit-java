package learn.junit.anas.javaunittest;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {
    private Queue<String> queue;


    @Nested
    @DisplayName("when new")
    public class whenNew{

        @BeforeEach
        void setup(){
            // artinya setiap kali sebelum sebuah test dijalankan,
            // objek queue akan di-reset menjadi kosong dan baru,
            // yaitu sebuah instance baru dari LinkedList<String>.
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer, size must be 1")
        void offerNewData(){
            // jika tanpa @BeforeAll queue = new LinkedList<>();
            queue.offer("Pro Joko");
            Assertions.assertEquals(1,queue.size());
        }

        @Test
        @DisplayName("when offer 2 data, size must be 2")
        void offerMoreData(){
            // jika tanpa @BeforeAll queue = new LinkedList<>();
            queue.offer("Pro Joko");
            queue.offer("Pro Kaltim");
            Assertions.assertEquals(2,queue.size());
        }
    }
}
