package sam.springframework.msscbeerservice.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import sam.springframework.msscbeerservice.domain.Beer;
import sam.springframework.msscbeerservice.repositories.BeerRepository;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0){
            beerRepository.save(Beer.builder().beerName("Sanmig Light")
                    .beerStyle("IPA")
                    .quantityToBrew(200)
                    .upc(33701000001L)
                    .price(new BigDecimal(12.95))
                    .build());

            beerRepository.save(Beer.builder().beerName("Galaxy Cat")
                    .beerStyle("PALE")
                    .quantityToBrew(200)
                    .upc(33701000002L)
                    .price(new BigDecimal(11.95))
                    .build());
        }
        System.out.println("Loaded beers: " + beerRepository.count());
    }


}
