select * from HIBERNATE_UNIQUE_KEY;
drop table APP.EVENTS;
select * from APP.PERSON;
select * from APP.AIRLINES;
help;
show indexes from app.airlines;
create index flightshistoryidx1 on app.flights_history ( flight_id, segment_number );
alter table app.flights_history add key (  )
alter table app.maps add primary key ( map_id );
select * from  app.maps;