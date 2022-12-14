CREATE TABLE IF NOT EXISTS masterdata_checkpoint
(
    ID BIGSERIAL PRIMARY KEY
);

ALTER TABLE masterdata_checkpoint
    ADD COLUMN IF NOT EXISTS spel_expression varchar(255) not NULL,
    ADD COLUMN IF NOT EXISTS description varchar(255) not NULL;

INSERT INTO masterdata_checkpoint(spel_expression, description)
VALUES ('countryCode != ''PL''', 'Is the flight ticked purchased?'),
       ('countryCode != ''PL''', 'Is covid test done?'),
       ('T(java.time.temporal.ChronoUnit).DAYS.between(startDate.toLocalDateTime().toLocalDate(),endDate.toLocalDateTime().toLocalDate()) >= 2', 'Is the hotel booked?'),
       ('true', 'Is diet paid off?'),
       ('true', 'Is meeting schedule definied?');