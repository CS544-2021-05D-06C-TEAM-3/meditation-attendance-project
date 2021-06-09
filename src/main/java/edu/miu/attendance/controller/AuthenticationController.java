package edu.miu.attendance.controller;

import edu.miu.attendance.config.JPAPersonDetails;
import edu.miu.attendance.config.JPAPersonDetailsService;
import edu.miu.attendance.domain.Course;
import edu.miu.attendance.dto.BadCredentialDto;
import edu.miu.attendance.dto.JwtTokenDto;
import edu.miu.attendance.dto.LoginRequestDto;
import edu.miu.attendance.dto.UserDataDto;
import edu.miu.attendance.security.JwtUtil;
import edu.miu.attendance.security.SecurityUtils;
import edu.miu.attendance.service.StudentService;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    JPAPersonDetailsService personDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    StudentService studentService;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequestDto loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(new BadCredentialDto("Invalid username and password!"));
        }
        UserDetails userDetails = personDetailsService.loadUserByUsername(loginRequest.getEmail());
        UserDataDto userData = new UserDataDto((JPAPersonDetails) userDetails);
        String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtTokenDto(token, userData));
    }

    @GetMapping("/courses")
    List<Course> getStudentCourses(@RequestParam(required = false) String q) {
        String username = SecurityUtils.getUsername();
        return studentService.getAllCoursesByStudent(1);
    }
}
