export interface PostOverviewModel {
  id: Number;
  title: String;
  creator: String;
  reward: Number;
  distance: Number;
}

export interface PostModel extends PostOverviewModel {
  description: String;
}
