package com.mnp.springbootvaadin.cities;


import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.HashMap;
import java.util.Map;

@Route("images_of_the_cities")
@StyleSheet("css/style.css")
public class ImagesOfTheCities extends VerticalLayout {
    public ImagesOfTheCities() {
        ComboBox comboBoxCities = new ComboBox("Cities");
        final Image[] image = new Image[1];

        comboBoxCities.setItems(getCityData().keySet().stream().sorted().toList());
        comboBoxCities.setPlaceholder("Select city");
        comboBoxCities.addValueChangeListener(event  -> {
            if(image[0] != null)
                remove(image[0]);


            String selectedCity = comboBoxCities.getValue().toString();
            image[0] = new Image(getCityData().get(selectedCity), "Something problem, Sorry!");
            add(image[0]);
        });

        add(comboBoxCities);
    }

    public static Map<String, String> getCityData(){
        Map<String, String> mapCities = new HashMap<String, String>();

        mapCities.put("Frankfurt", "https://mocah.org/thumbnail/461879-city-cityscape-sky-clouds-Germany-Frankfurt.jpg");
        mapCities.put("Hong Kong", "https://mocah.org/thumbs/113673-hong-kong-china-tourism-travel.jpg");
        mapCities.put("London", "https://mocah.org/thumbs/5425574-london-bridge-sunrise-river-thames-sunset-bridges-golden-light-golden-gate-bridge-sunset-light-london-london-eye-london-city-city-line-city-at-night-city-skyline-city-vie-city-view-drone-view-.jpg");
        mapCities.put("Los Angeles", "https://mocah.org/thumbs/541508-los-angeles.jpg");
        mapCities.put("New York", "https://mocah.org/thumbs/5318747-city-urban-sunset-sunrise-moon-lake-water-sea-ocean-tower-skyscraper-cityscape-pink-blue-building-new-york-city-new-york-photography-landscape-wtc-free-stock-photos.jpg");
        mapCities.put("Paris", "https://mocah.org/thumbnail/442952-Paris-Eiffel-Tower-garden-France-cityscape-city.jpg");
        mapCities.put("San Francisco", "https://mocah.org/thumbs/720775-USA-Bridges-Night-San-Francisco-California.jpg");
        mapCities.put("Singapore", "https://mocah.org/thumbs/535988-architecture.jpg");
        mapCities.put("Sydney", "https://mocah.org/thumbs/558581-Sydney-Circular.jpg");
        mapCities.put("Tokyo", "https://mocah.org/thumbs/130197-tokyo-tower-tokyo-japan-cityscape-skyline-hd-4k.jpg");
        mapCities.put("Vancouver", "https://mocah.org/thumbs/847017-Canada-Houses-Coast-Vancouver.jpg");
        mapCities.put("Warsaw", "https://mocah.org/thumbs/1002486-city-cityscape-architecture-skyline-skyscraper-tower-Poland-Warsaw-birds-eye-view-metropolis-downtown-condominium-landmark-suburb-urban-area-metropolitan-area-human-set.jpg");

        return mapCities;
    }
}
