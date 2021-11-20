package com.example.help.me.Repository;

import com.example.help.me.Models.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message,Long>{
    List<Message> findByMessage(String message);
}
