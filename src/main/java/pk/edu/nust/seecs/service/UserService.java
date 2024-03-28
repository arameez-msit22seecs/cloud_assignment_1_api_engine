package pk.edu.nust.seecs.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pk.edu.nust.seecs.dao.UserRepo;
import pk.edu.nust.seecs.domain.UserReqModel;
import pk.edu.nust.seecs.entity.User;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepo userRepo;


    @Transactional
    public String save(UserReqModel reqData) {

        System.out.printf("");

        User newUser = User.builder()
                .username(reqData.getUsername())
                .password(reqData.getPassword())
                .build();

        try {
            userRepo.save(newUser);
            return "Success";

        } catch (Exception exception) {

            return "Failure";
        }

    }

    public String login(UserReqModel reqData){
        try {
            Optional<User> existingUser = userRepo.getUsersByUsernameAndPassword(reqData.getUsername(), reqData.getPassword());

            if (existingUser.isPresent()) {
                return "Valid";
            }

            return "InValid";
        } catch (Exception exception) {

            return "Failure";
        }

    }


}
