package com.example.projeto_002.database.dao

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.projeto_002.database.AppDatabase
import com.example.projeto_002.model.Owner
import com.example.projeto_002.model.PullRequest
import com.example.projeto_002.model.Repository
import com.example.projeto_002.model.User
import com.google.common.truth.Truth.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class GitRepositoryDAOTest {

    private lateinit var database: AppDatabase
    private lateinit var dao: GitRepositoryDAO


    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.getGitHubRepository()
    }

    @After

    fun teardown() {
        database.close()
    }

    @Test
    fun testing_insert_github_model_should_retrune_true() {

        val githubMOdelToInsert = Repository(
            id = 1L,
            nameRepository = "Kotlin",
            description = null,
            details = PullRequest(
                title = "A",
                createdAt = "12-12",
                namePull = "a",
                userPull = User(
                    login = "aa",
                    avatarUrlUser = "a"),
                body = "",
                htmlUrl = "",
                id = 1L
            ),
            forks = 1,
            language = "",
            owner = Owner(1L, avatarUrlOwner = "", idOwner = 1, login = "a"),
            pullsUrl = "",
            stars = 4
        )

        dao.insert(arrayListOf(githubMOdelToInsert))

        val results = dao.getAll()
        assertThat(results).contains(githubMOdelToInsert)
    }

    @Test
    fun testing_total_by_lang_should_returns_true(){

        val githubModelToInsert1 = Repository(

            id = 1L,
            nameRepository = "",
            description = null,
            details = PullRequest(
                title = "A",
                createdAt = "12-12",
                namePull = "a",
                userPull = User(
                    login = "aa",
                    avatarUrlUser = "a"),
                body = "",
                htmlUrl = "",
                id = 1L
            ),
            forks = 1,
            language = "Kotlin",
            owner = Owner(1L, avatarUrlOwner = "", idOwner = 1, login = "a"),
            pullsUrl = "",
            stars = 4
        )

        val githubModelToInsert2 = Repository(

            id = 1L,
            nameRepository = "",
            description = null,
            details = PullRequest(
                title = "A",
                createdAt = "12-12",
                namePull = "a",
                userPull = User(
                    login = "aa",
                    avatarUrlUser = "a"),
                body = "",
                htmlUrl = "",
                id = 1L
            ),
            forks = 1,
            language = "Kotlin",
            owner = Owner(1L, avatarUrlOwner = "", idOwner = 1, login = "a"),
            pullsUrl = "",
            stars = 4
        )

        val githubModelToInsert3 = Repository(

            id = 1L,
            nameRepository = "",
            description = null,
            details = PullRequest(
                title = "A",
                createdAt = "12-12",
                namePull = "a",
                userPull = User(
                    login = "aa",
                    avatarUrlUser = "a"),
                body = "",
                htmlUrl = "",
                id = 1L
            ),
            forks = 1,
            language = "Java",
            owner = Owner(1L, avatarUrlOwner = "", idOwner = 1, login = "a"),
            pullsUrl = "",
            stars = 4
        )

        dao.insert(arrayListOf(githubModelToInsert1, githubModelToInsert2, githubModelToInsert3))
        val result = dao.getTotalByLanguge("Kotlin")
        assertThat(result).isEqualTo(2)
    }

}