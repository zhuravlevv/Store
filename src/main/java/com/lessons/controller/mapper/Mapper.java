package com.lessons.controller.mapper;

public interface Mapper<Entity, Dto> {

    public Dto fromEntity(Entity entity);

    public Entity toEntity(Dto dto);
}
