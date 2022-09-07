package com.example.springbootsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/companies/allCompanies").hasAnyAuthority("ADMIN","MANAGER","STUDENT","INSTRUCTOR")
                .antMatchers("/companies/newCompany").hasAuthority("ADMIN")
                .antMatchers("/companies/update/{id}").hasAuthority("ADMIN")
                .antMatchers("/companies/delete/{id}").hasAuthority("ADMIN")
                .antMatchers("/courses/allCourses/{companyId}").hasAnyAuthority("ADMIN","INSTRUCTOR")
                .antMatchers("/courses/{companyId}/newCourse").hasAuthority("ADMIN")
                .antMatchers("/courses/{id}/{courseId}/delete").hasAuthority("ADMIN")
                .antMatchers("/courses/{companyId}/{courseId}/saveAssign").hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers("/courses/update/{courseId}").hasAnyAuthority("ADMIN","MANAGER","INSTRUCTOR")
                .antMatchers("/instructors/allInstructors/{companyId}").hasAnyAuthority("INSTRUCTOR","ADMIN","MANAGER")
                .antMatchers("/instructors/{companyId}/newInstructor").hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers("/instructors/updateInstructor/{instructorId}").hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers("/instructors/{id}/{instructorId}/delete").hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers("/students/allStudents/{companyId}").hasAnyAuthority("ADMIN","MANAGER","INSTRUCTOR")
                .antMatchers("students/{companyId}/newStudent").hasAnyAuthority("ADMIN","MANAGER")
                .antMatchers("/students/update/{studentId}").hasAnyAuthority("ADMIN","INSTRUCTOR","MANAGER")
                .antMatchers("/students/{studentId}/{courseId}/delete").hasAnyAuthority("ADMIN","MANAGER","INSTRUCTOR")
                .antMatchers("/students/{companyId}/{studentId}/assign").hasAnyAuthority("ADMIN","STUDENT","MANAGER","INSTRUCTOR")
                .antMatchers("/lessons/{courseId}/{lessonId}/deleteLesson").hasAnyAuthority("ADMIN","MANAGER","INSTRUCTOR")
                .antMatchers("/lessons/updateLesson/{lessonId}").hasAuthority("INSTRUCTOR")
                .antMatchers("/lessons/{courseId}/newLesson").hasAuthority("INSTRUCTOR")
                .antMatchers("/tasks/allTasks/{lessonId}").hasAnyAuthority("INSTRUCTOR","STUDENT","ADMIN")
                .antMatchers("/tasks/{lessonId}/newTask").hasAnyAuthority("INSTRUCTOR","ADMIN")
                .antMatchers("/tasks/updateTask/{taskId}").hasAuthority("INSTRUCTOR")
                .antMatchers("/tasks/{lessonId}/{taskId}/deleteTask").hasAnyAuthority("INSTRUCTOR")
                .antMatchers("/videos/allVideos/{lessonId}").hasAnyAuthority("INSTRUCTOR","STUDENT","ADMIN","MANAGER")
                .antMatchers("/videos/{lessonId}/newVideo").hasAuthority("INSTRUCTOR")
                .antMatchers("/videos/updateVideo/{videoId}").hasAuthority("INSTRUCTOR")
                .antMatchers("/videos/{lessonId}/{videoId}/deleteVideo").hasAuthority("INSTRUCTOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()

                .permitAll()
//                .defaultSuccessUrl("/companies/allCompanies")
                .and()
                .logout().permitAll();
    }
}
