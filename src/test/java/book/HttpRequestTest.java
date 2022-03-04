package book;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void addressBookShouldBeEmpty() throws Exception {
        String url = "http://localhost:" + this.port + "/addressbook";
        System.out.println(this.restTemplate.getForObject(url, String.class));
//        assertThat(this.restTemplate.getForObject(url, String.class));
    }

    public void addNewBuddyShouleBeOne() throws Exception {

    }

}