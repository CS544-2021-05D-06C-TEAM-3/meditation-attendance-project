package edu.miu.attendance.security;

import edu.miu.attendance.config.JPAPersonDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    public static String getUsername() {
        JPAPersonDetails userDetails = (JPAPersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getUsername();
    }

    public static boolean isOrganizationUser() {
        JPAPersonDetails userDetails = (JPAPersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getRoles().stream().anyMatch(r -> r.getRole().equals("FACULTY"));//name for org
    }
}