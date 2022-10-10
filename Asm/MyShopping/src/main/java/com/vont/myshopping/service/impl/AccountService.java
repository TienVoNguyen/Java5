package com.vont.myshopping.service.impl;

import com.vont.myshopping.models.entity.Account;
import com.vont.myshopping.models.entity.ERole;
import com.vont.myshopping.models.entity.Role;
import com.vont.myshopping.payload.request.SignupRequest;
import com.vont.myshopping.payload.response.MessageResponse;
import com.vont.myshopping.repository.AccountRepository;
import com.vont.myshopping.repository.RoleRepository;
import com.vont.myshopping.service.IAccountService;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    public AccountService(AccountRepository accountRepository, RoleRepository roleRepository, PasswordEncoder encoder) {
        this.accountRepository = accountRepository;
        this.roleRepository = roleRepository;
        this.encoder = encoder;
    }

    @Override
    public Account save(Account account) {
        return null;
    }

    @Override
    public void delete(long[] ids) {

    }

    @Override
    public Account findById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }

    @Override
    public List<Account> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public MessageResponse registerUser(SignupRequest signUpRequest) {
        if (accountRepository.existsByUsername(signUpRequest.getUsername())) {
            return new MessageResponse("Error: Username is already taken!");
        }

        if (accountRepository.existsByEmail(signUpRequest.getEmail())) {
            return new MessageResponse("Error: Email is already in use!");
        }

        // Create new user's account
        Account user = Account.builder()
                .username(signUpRequest.getUsername())
                .email(signUpRequest.getEmail())
                .password(encoder.encode(signUpRequest.getPassword()))
                .fullName(signUpRequest.getFullName())
                .phoneNumber(signUpRequest.getPhoneNumber())
                .dob(signUpRequest.getDob())
                .address(signUpRequest.getAddress())
                .gender(signUpRequest.getGender())
                .build();

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin" -> {
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);
                    }
                    case "staff" -> {
                        Role modRole = roleRepository.findByName(ERole.ROLE_STAFF)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);
                    }
                    default -> {
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                    }
                }
            });
        }

        user.setRoles(roles);
        accountRepository.save(user);

        return new MessageResponse("User registered successfully!");
    }
}
