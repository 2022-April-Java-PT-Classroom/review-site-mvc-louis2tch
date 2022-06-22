package org.wecancoeit.reviews;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wecancoeit.reviews.model.Review;
import org.wecancoeit.reviews.model.ReviewCategory;
import org.wecancoeit.reviews.model.User;
import org.wecancoeit.reviews.repo.ReviewCategoryRepository;
import org.wecancoeit.reviews.repo.ReviewRepository;
import org.wecancoeit.reviews.repo.UserRepository;

import javax.annotation.Resource;

@Component
public class PopulateComponent implements CommandLineRunner{

    @Resource
    private ReviewRepository reviewStorage;

    @Resource
    private ReviewCategoryRepository reviewCategoryStorage;

    @Resource
    private UserRepository userStorage;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Louis","/images/louis02.jpg");
        User user2 = new User("Tom","/images/discours.jpg");
        User user3 = new User("Therese","/images/sure.jpg");
        User user4 = new User("Antoine","/images/talk.jpg");
        userStorage.save(user1);
        userStorage.save(user2);
        userStorage.save(user3);
        userStorage.save(user4);

        ReviewCategory category1 = new ReviewCategory("Science and Technology","Advances in " +
                "science and technology can quickly become indispensable in our daily lives and to the nation as a whole. Policymakers need reliable, timely information on science and technology topics as rapid developments " +
                "increase complexity and affect the economy, national security, and more.",
                "/images/science.jpg","https://www.gao.gov/science-technology");

        ReviewCategory category2 = new ReviewCategory("Nature","The world " +
                "is in the midst of a climate crisis that is made worse by a biodiversity crisis. " +
                "Wild Nature Institute programs address these two crises at the same time through science," +
                " education, and action. " +
                "Protecting Wild Nature and  Biodiversity is our best defense against the climate crisis.",
                "/images/nature.jpg","https://www.wildnatureinstitute.org/");

        ReviewCategory category3 = new ReviewCategory("Theatre","Ancient Greek theatre was " +
                "a theatrical culture that flourished in ancient Greece from 700 BC. The city-state " +
                "of Athens, which became a significant cultural, political, and religious place during " +
                "this period, was its centre, where the theatre was institutionalised as part of a festival" +
                " called the Dionysia, which honoured the god Dionysus. Tragedy (late 500 BC), comedy " +
                "(490 BC), and the satyr play were the three dramatic genres to emerge there.",
                "/images/theatre.jpg","https://en.wikipedia.org/wiki/Theatre_of_ancient_Greece");

        reviewCategoryStorage.save(category1);
        reviewCategoryStorage.save(category2);
        reviewCategoryStorage.save(category3);

        Review review1 = new Review("06/13/2022","Hummingbird watching", "Very impressive! " +
                "you can spend the whole day there without realizing it","",user1, category2);

        Review review2 = new Review("06/7/2022","The kingfisher", "They have a" +
                " cosmopolitan distribution, with most species found in the tropical regions of" +
                " Africa, Asia, and Oceania but also can be seen in Europe. They can be found " +
                "in deep forests near ..","",user3, category2);

        Review review3 = new Review("06/1/2022","The Navier-Stokes equations", "The Navier " +
                "Stokes equation is so hard to solve because it is non-linear. If the inertial " +
                "terms were not present (either because of the geometry or because the inertial " +
                "terms are negligible0, it would (and can) " +
                "be much easier to solve ...","",user2, category1);

        Review review4 = new Review("05/25/2022","My first impression at the Greek theater", "For me the tragedy's most " +
                "important act is the sixth: " +
                "the raising of the dead from the stage's battlegrounds " +
                "the straightening of wigs and fancy gowns " +
                "removing knives from stricken breasts, " +
                "taking nooses from lifeless necks," +
                "lining up among the living " +
                "to face the audience.","",user1, category3);

        reviewStorage.save(review1);
        reviewStorage.save(review2);
        reviewStorage.save(review3);
        reviewStorage.save(review4);
        //reviewStorage.deleteById(4L);
       // reviewStorage.

    }


}
