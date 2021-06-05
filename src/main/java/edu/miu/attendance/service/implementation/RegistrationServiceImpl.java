package edu.miu.attendance.service.implementation;

import edu.miu.attendance.domain.Registration;
import edu.miu.attendance.repository.RegistrationRepository;
import edu.miu.attendance.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    RegistrationRepository registrationDAO;


    @Override
    public Registration register(Registration registration) {
        return registrationDAO.save(registration);
    }
}
