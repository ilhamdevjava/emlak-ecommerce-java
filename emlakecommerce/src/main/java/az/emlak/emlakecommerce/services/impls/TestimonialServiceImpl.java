package az.emlak.emlakecommerce.services.impls;


import az.emlak.emlakecommerce.dtos.testimonial.TestimonialDto;
import az.emlak.emlakecommerce.model.Testimonial;
import az.emlak.emlakecommerce.repositories.TestimonialRepository;
import az.emlak.emlakecommerce.services.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;


    @Override
    public List<Testimonial> getAllTestimonials() {
        return testimonialRepository.findAll();
    }

    @Override
    public void deleteTestimonial(Long id) {

    }
}
