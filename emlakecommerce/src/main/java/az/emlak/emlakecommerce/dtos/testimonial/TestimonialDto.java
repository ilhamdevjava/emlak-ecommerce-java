package az.emlak.emlakecommerce.dtos.testimonial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestimonialDto {
    private Long id;
    private String authorName;
    private String authorPosition;
    private String feedback;
    private String authorImage;
}
