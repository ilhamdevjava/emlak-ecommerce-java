package az.emlak.emlakecommerce.services;

import az.emlak.emlakecommerce.model.About;

public interface AboutService {

    About getAboutInfo();

    About getAboutById(Long id) ;
}
