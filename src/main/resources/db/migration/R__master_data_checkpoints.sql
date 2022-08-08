CREATE TABLE masterdata_checkpoint (
                                       id serial PRIMARY KEY,
                                       spel_expression varchar(255) not NULL,
                                       description varchar(255) not NULL
);
 
INSERT INTO masterdata_checkpoint(spel_expression, description) VALUES
                                                                    ('country != ''PL''', 'Is the flight ticked purchased?'),
                                                                    ('country != ''PL''', 'Is covid test done?'),
                                                                    ('T(java.time.temporal.ChronoUnit).DAYS.between(date_begin,date_end) >= 2', 'Is the hotel booked?'),
                                                                    ('true', 'Is diet paid off?'),
                                                                    ('true', 'Is meeting schedule definied?');