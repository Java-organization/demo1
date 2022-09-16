package com.example.demo.controller;

import com.example.demo.entity.TestEntity;
import com.example.demo.logger.MainLogger;
import com.example.demo.response.TestResponse;
import com.example.demo.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //   menim testcontoller clasim burda olacaq.userlerin muelumatini almaq istesek
//local host:8080/users-bu requestden men biliremki burdan butun muelumatlar cekmek istenilir.
//api-applocation programming interface. backEndin interfacesi sayilir.front backende gonderir
//api-ler her metodunda olur, butov klasinda ola biler
@RequestMapping("v1/api/test")
//root api sayilir. esas kok hisse.v1 burda version dur. test ise controllorun uygun oldugu addir.
// ilk api geldikde controller classlarin icinde axtarir.
@RequiredArgsConstructor
public class TestController {

    // Get Post Delete Put -PROTOCOL.  GET MUELUMATLARI GONDERMEK(select kimi).
    // Post- userin muel qeydiyyatdan kecirdirem(insert),
//put update emel yerine yetirmek.

    private final TestService testService;
    private MainLogger log= MainLogger.getLogger(TestService.class);


    @GetMapping
    List<TestResponse> getTests() {
        return testService.getTests();
    }

    @GetMapping("/{id}")
    com.example.demo.response.TestResponse getTest(@PathVariable Long id) {
        log.info("searching Test for id "+id);
        return testService.getTest(id);
    }

    @PostMapping
    void saveTest(@RequestBody TestEntity t)  {
        testService.saveTest(t);
    }

    @DeleteMapping("/{id}")
    void deleteTest(@PathVariable Long id) {
        log.warn("deleted Test for id {}",id);
        testService.deleteTest(id);
    }

    @PutMapping()
    TestEntity updateTest(@RequestBody TestEntity testEntity)  {
        return testService.updateTest(testEntity);
    }


    @PatchMapping("/{id}")
    TestEntity updatePhone(@PathVariable Long id,@RequestBody String phoneNumber) {
        return testService.updatePhone(id,phoneNumber);
    }
}