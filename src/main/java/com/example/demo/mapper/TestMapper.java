package com.example.demo.mapper;

import com.example.demo.entity.TestEntity;
import com.example.demo.response.TestResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface TestMapper {
    @Mapping(target = "fullName", expression = "java(testEntity.getName()+\" \"+testEntity.getSurname())")
    @Mapping(target = "gender", source = "gender.name")
    default TestResponse toTestResponse(TestEntity testEntity) {
        return null;
    }

    List<TestResponse> toTestResponses(List<TestEntity> testEntities);


}
