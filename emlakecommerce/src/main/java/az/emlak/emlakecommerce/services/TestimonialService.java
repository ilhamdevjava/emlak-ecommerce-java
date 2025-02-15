package az.emlak.emlakecommerce.services;






import az.emlak.emlakecommerce.model.Testimonial;

import java.util.List;

public interface TestimonialService {
    List<Testimonial> getAllTestimonials();
    void deleteTestimonial(Long id);
}
