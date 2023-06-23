use keijiban;
CREATE TABLE IF NOT EXISTS keijiban.trn_posts
(
    post_id          INT          NOT NULL AUTO_INCREMENT,
    author_name      VARCHAR(256) NOT NULL,
    post_message     TEXT         NOT NULL,
    password         VARCHAR(256),
    created_datetime DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_datetime DATETIME,
    PRIMARY KEY (post_id)
) engine = InnoDB
  default charset = utf8;