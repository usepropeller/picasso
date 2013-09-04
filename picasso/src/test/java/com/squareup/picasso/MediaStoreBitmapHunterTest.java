package com.squareup.picasso;

import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.squareup.picasso.MediaStoreBitmapHunter.PicassoKind.MICRO;
import static com.squareup.picasso.MediaStoreBitmapHunter.PicassoKind.MINI;
import static com.squareup.picasso.MediaStoreBitmapHunter.getPicassoKind;
import static org.fest.assertions.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class MediaStoreBitmapHunterTest {

  @Test public void getPicassoKindMicro() throws IOException {
    assertThat(getPicassoKind(96, 96)).isEqualTo(MICRO);
    assertThat(getPicassoKind(95, 95)).isEqualTo(MICRO);
    assertThat(getPicassoKind(1000, 96)).isEqualTo(MICRO);
  }

  @Test public void getPicassoKindMini() throws IOException {
    assertThat(getPicassoKind(512, 384)).isEqualTo(MINI);
    assertThat(getPicassoKind(100, 100)).isEqualTo(MINI);
    assertThat(getPicassoKind(1000, 384)).isEqualTo(MINI);
  }

  @Test public void getPicassoKindNull() throws IOException {
    assertThat(getPicassoKind(513, 385)).isNull();
    assertThat(getPicassoKind(1000, 1000)).isNull();
  }
}
