package az.emlak.emlakecommerce.services.impls;

import az.emlak.emlakecommerce.model.About;
import az.emlak.emlakecommerce.repositories.AboutRepository;
import az.emlak.emlakecommerce.services.AboutService;
import org.springframework.stereotype.Service;

@Service
public class AboutServiceImpl implements AboutService {

private final AboutRepository aboutRepository;

    public AboutServiceImpl(AboutRepository aboutRepository) {
        this.aboutRepository = aboutRepository;
    }

    @Override
    public About getAboutInfo() {
        // Tək bir "About" obyektini qaytarır (ID ilə və ya ilk qeydi gətirə bilərsiniz)
        return aboutRepository.findById(1L).orElseThrow(() -> new RuntimeException("About məlumat tapılmadı"));
    }

    @Override
    public About getAboutById(Long id) {
        return aboutRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("About bulunamadı"));
    }
}
