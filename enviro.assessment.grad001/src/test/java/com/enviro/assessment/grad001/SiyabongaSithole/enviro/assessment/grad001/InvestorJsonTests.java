package com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001;

import com.enviro.assessment.grad001.SiyabongaSithole.enviro.assessment.grad001.Investor.Investor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class InvestorJsonTests {

    @Autowired
    private JacksonTester<Investor> json;

    @Test
    void investorSerializationTest() throws IOException {
        Investor investor = new Investor( 50L,"John",
                "Edwards",
                "Johannesburg south 1033",
                "JoEdw@gmail.com",
                "0873351426",new ArrayList<>());
        assertThat(json.write(investor)).isStrictlyEqualToJson("expected.json");
        assertThat(json.write(investor)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(investor)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(50L);
        assertThat(json.write(investor)).hasJsonPathNumberValue("@.lastName");
        assertThat(json.write(investor)).extractingJsonPathNumberValue("@.lastName")
                .isEqualTo("Edwards");
    }
}
