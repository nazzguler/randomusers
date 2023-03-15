package com.example.randomusers.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.size.OriginalSize
import com.example.network.api.responses.User
import com.example.network.api.responses.UserName
import com.example.randomusers.R
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

@Composable
fun RandomUsersScreen(
    vm: RandomUsersViewModel
) {
    val state = vm.state.collectAsState()

    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing = state.value.inProgress),
        onRefresh = { vm.fetchRandomUsers() }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            state.value.users.forEach { _user ->
                item {
                    UserItem(user = _user)
                }
            }
        }
    }
}

@OptIn(ExperimentalCoilApi::class)
@Composable
fun UserItem(
    modifier: Modifier = Modifier,
    user: User
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .then(modifier)
            .padding(bottom = 10.dp)
            .padding(horizontal = 15.dp)
            .shadow(10.dp),
        elevation = 0.dp,
        shape = RoundedCornerShape(5.dp)
    ) {
        val painter = rememberImagePainter(data = user.picture?.medium) {
            size(OriginalSize)
        }
        ConstraintLayout(
            modifier = Modifier.fillMaxWidth(),
            constraintSet = ConstraintSet {
                val picture = createRefFor("picture")
                val fullName = createRefFor("fullName")
                val email = createRefFor("email")

                constrain(picture) {
                    linkTo(start = parent.start, end = fullName.start, bias = 0F)
                    linkTo(top = parent.top, bottom = parent.bottom)
                }
                constrain(fullName) {
                    linkTo(start = picture.end, end = parent.end, bias = 0F)
                    linkTo(top = parent.top, bottom = email.top)
                    width = Dimension.fillToConstraints
                }
                constrain(email) {
                    linkTo(start = picture.end, end = parent.end, bias = 0F)
                    linkTo(top = fullName.bottom, bottom = parent.bottom)
                }
            }
        ) {
            if (painter.state is ImagePainter.State.Success) {
                Image(
                    modifier = Modifier
                        .layoutId("picture")
                        .padding(end = 20.dp)
                        .size(120.dp),
                    contentDescription = null,
                    painter = painter
                )
            } else {
                Image(
                    modifier = Modifier
                        .layoutId("picture")
                        .padding(end = 20.dp)
                        .size(120.dp),
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    contentScale = ContentScale.Inside
                )
            }
            Text(
                modifier = Modifier.layoutId("fullName"),
                text = user.getFullName()
            )
            Text(
                modifier = Modifier.layoutId("email"),
                text = user.email ?: "-"
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    val user1 = User(
        name = UserName(first = "User", last = "One", title = null),
        email = "user.one@test.test",
        gender = "male",
        picture = null,
        phone = "(111)-111-11-11"
    )
    val user2 = User(
        name = UserName(first = "User", last = "Two", title = null),
        email = "user.two@test.test",
        gender = "female",
        picture = null,
        phone = "(222)-222-22-22"
    )
    LazyColumn {
        listOf(user1, user2).forEach { _user ->
            item {
                UserItem(user = _user)
            }
        }
    }
}