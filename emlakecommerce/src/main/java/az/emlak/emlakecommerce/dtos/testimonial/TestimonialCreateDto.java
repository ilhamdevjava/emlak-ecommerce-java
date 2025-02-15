package az.emlak.emlakecommerce.dtos.testimonial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestimonialCreateDto {
    private String authorName;
    private String authorPosition;
    private String feedback;
    private MultipartFile authorImage;
}
