package edu.miu.attendance.controller;

import edu.miu.attendance.config.JPAPersonDetails;
import edu.miu.attendance.config.JPAPersonDetailsService;
import edu.miu.attendance.dto.BadCredentialDto;
import edu.miu.attendance.dto.JwtTokenDto;
import edu.miu.attendance.dto.LoginRequestDto;
import edu.miu.attendance.dto.UserDataDto;
import edu.miu.attendance.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    JwtUtil jwtUtil;
    @Autowired
    JPAPersonDetailsService personDetailsService;
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BadCredentialDto("Invalid username and password"));
        }
        UserDetails userDetails = personDetailsService.loadUserByUsername(loginRequest.getUsername());
        UserDataDto userData = new UserDataDto((JPAPersonDetails) userDetails);
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtTokenDto(token, userData));
    }
}
