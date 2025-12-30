package content;

import java.time.Year;
import java.util.ArrayList;

public class ContentDemo {

    public static void main(String[] args) {

        ArrayList<ContentItem> items = new ArrayList<>();

        items.add(new VideoLecture("Java Basics", 2024, 120, "HD"));
        items.add(new VideoLecture("OOP in Java", 2023, 90, "4K"));

        items.add(new PodcastEpisode("Tech Talk", 2024, 45, "Alice"));
        items.add(new PodcastEpisode("Dev Life", 2022, 60, "Bob"));

        int currentYear = Year.now().getValue();

        for (ContentItem item : items) {
            System.out.println(item +
                    " | licenseCost=" +
                    item.getLicenseCost(currentYear));

            if (item instanceof Downloadable) {
                Downloadable d = (Downloadable) item;
                d.download();
                System.out.println("Max downloads per day: " + d.getMaxDownloadsPerDay());
            }

            System.out.println("--------------------------------");
        }
    }
}
