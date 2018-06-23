package com.test.week0502.multi;
import android.support.annotation.NonNull;

import java.util.List;

/**
 * @author drakeet
 */
public class PostList {

  final @NonNull
  List<Post> posts;


  public PostList(@NonNull List<Post> posts) { this.posts = posts; }
}
