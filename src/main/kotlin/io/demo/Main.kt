package io.demo

import io.demo.dto.getMostRatedNews
import io.demo.service.NewsService
import kotlinx.coroutines.runBlocking
import mu.KotlinLogging
import java.time.LocalDate


private val logger = KotlinLogging.logger {}

fun main() = runBlocking{
    val newsService = NewsService()

    try {
        val news = newsService.getNews()

        logger.info("You have successfully received ${news.size} news items")

        val mostRatedNews = news.getMostRatedNews(5, LocalDate.now())

        logger.info("${mostRatedNews.size} news with the most rating has been successfully filtered")

        println("Response text: $mostRatedNews")

        newsService.saveNews("src/main/resources/news.csv", mostRatedNews)

    } catch (e: Exception) {
        logger.error("An error occurred while processing", e)
    }
}
