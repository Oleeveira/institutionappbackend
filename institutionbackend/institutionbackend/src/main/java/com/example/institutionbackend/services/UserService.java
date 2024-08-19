package com.example.institutionbackend.services;

import com.example.institutionbackend.models.User;
import com.example.institutionbackend.repositories.UserRepository;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    User user;
    private static final String COLLECTION_NAME = "users";

    public UserRecord loginUser(String email, String password) throws FirebaseAuthException {
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setPassword(password);

        return FirebaseAuth.getInstance().createUser(request);

    }

    public String createUser(User newUser) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture=dbFirestore.collection(COLLECTION_NAME).document(newUser.getEmail()).set(newUser);

        return collectionApiFuture.get().getUpdateTime().toString();
    }

    public User getUser(User user){
        return user;
    }

    public User updateUser(User User){
        return User;
    }

    public User deleteUser(User User){
        return User;
    }


    public void getUser(Optional<User> user) {
    }
}
