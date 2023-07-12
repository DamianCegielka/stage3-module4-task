package com.mjc.school;

import com.mjc.school.model.AuthorModel;
import com.mjc.school.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    private static final String FILE_PATH_DATA_SOURCE_NEWS = "module-repository\\src\\main\\resources\\newsdc.txt";
    private static final String FILE_PATH_DATA_SOURCE_AUTHOR = "module-repository\\src\\main\\resources\\authordc.txt";

    private List<NewsModel> listNews = new ArrayList<>();
    private List<AuthorModel> listAuthor = new ArrayList<>();

    public List<NewsModel> getListNews() {
        return listNews;
    }

    public List<AuthorModel> getListAuthor() {
        return listAuthor;
    }


    public void loadNewsFromDataSource() {
/*
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH_DATA_SOURCE_NEWS))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrayLine = line.split(";");
                NewsModel news = new NewsModel();
                news.setId(Long.valueOf(arrayLine[0]));
                news.setTitle(arrayLine[1]);
                news.setContent(arrayLine[2]);
                news.setCreateDate(LocalDateTime.parse(arrayLine[3]));
                news.setLastUpdateTime(LocalDateTime.parse(arrayLine[4]));
                news.setAuthorId(Long.parseLong(arrayLine[5]));
                listNews.add(news);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

 */
    }

    public void loadAuthorsFromDataSource() {
        /*

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH_DATA_SOURCE_AUTHOR))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrayLine = line.split(";");
                AuthorModel author = new AuthorModel();
                author.setId(Long.parseLong(arrayLine[0]));
                author.setName(arrayLine[1]);
                listAuthor.add(author);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

         */
    }


}