package com.example.demo.mapper;

import com.example.demo.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {

	@Insert("insert into article(admin_account,title,keywords,summary,content,pub_date) values (#{account},#{title},#{classify},#{subject},#{content},#{date})")
	Integer addArticle(Article article);

	@Delete("DELETE FROM ARTICLE WHERE ARTICLE_ID = #{id}")
	Integer deleteArticleById(Integer id);

	@Update("UPDATE ARTICLE SET admin_account=#{account}, title=#{title}, keywords=#{classify}, summary=#{subject}, content=#{content}, pub_date=#{date} WHERE ARTICLE_ID = #{id}")
	Integer updateArticle(Article article);

	List<Article> listArticleByPubDate();


	// 测试成功
	@Select("SELECT ARTICLE_ID AS id, admin_account AS account, title ,keywords AS classify,summary AS subject,content,pub_date AS date FROM ARTICLE WHERE ARTICLE_ID = #{id}")
	Article getArticleById(Integer id);

	@Select("SELECT ARTICLE_ID AS id, admin_account AS account, title ,keywords AS classify,summary AS subject,content,pub_date AS date FROM ARTICLE")
	List<Article> listArticleAll();
	
}
