--- Athletic Building ---
INSERT INTO AthleticBuilding(name, hours) VALUES
('Tait McKenzie Centre', '["Mon - Thu: 6am-11:30pm", "Fri: 6am-10pm", "Sat: 9am-10pm", "Sun: 9am-5:30pm"]'), ('Fitness Centre', '["Mon - Fri: 6am-10pm", "Sat: 10am-7pm", "Sun: 9am-5pm"]')
ON CONFLICT (name) DO NOTHING;

--- Water Bottle Refill Stations ---
INSERT INTO WaterRefill(campus, building, location) VALUES
('Keele', 'Central Square', 'Outside Central Square Cafeteria'), ('Keele', 'Centre for Film & Theatre', 'Near Starbucks between washrooms'),
('Keele', 'Joan & Martin Goldfarb Centre for Fine Arts', 'Near dance studios on 1st floor'), ('Keele', 'Health, Nursing & Environmental Studies', '1st floor lobby by elevators'),
('Keele', 'Ignat Kaneff Bldg (Osgoode Hall Law School)', 'Basement across from locker room 023'), ('Keele', 'Ignat Kaneff Bldg (Osgoode Hall Law School)', 'Main floor within Bistro'),
('Keele', 'Ignat Kaneff Bldg (Osgoode Hall Law School)', 'Main floor by washroom alcove 141-D'), ('Keele', 'Ignat Kaneff Bldg (Osgoode Hall Law School)', 'Next to room 194'),
('Keele', 'Ignat Kaneff Bldg (Osgoode Hall Law School)', '2nd floor near women''s washroom 201A'), ('Keele', 'Ignat Kaneff Bldg (Osgoode Hall Law School)', '3rd floor by washroom alcove 392'),
('Keele', 'Ignat Kaneff Bldg (Osgoode Hall Law School)', '4th floor near women''s washroom rm 492'), ('Keele', 'Life Sciences Building', 'Main floor near washrooms rm 195'),
('Keele', 'Life Sciences Building', '2nd floor by washroom rm 296'), ('Keele', 'Ross Building South Tower', 'Near room South 816'),
('Keele', 'Ross Building South Tower', 'Near room South 889'), ('Keele', 'Scott Library', 'Main entrance near Circulation Desk'),
('Keele', 'Schulich School of Business', 'Main floor by food service area'), ('Keele', 'Stong College', 'Across from room 208'),
('Keele', 'Student Centre', 'Main floor by Undergrad entrance'), ('Keele', 'Tait McKenzie - York Field House', 'Next to room 284'),
('Keele', 'TEL Building', 'Next to room 1014A'), ('Keele', 'Toronto Track & Field Centre', 'By main entrance'),
('Keele', 'Toronto Track & Field Centre', 'By weight room'), ('Keele', 'Vanier College', 'Across from room 135'), ('Keele', 'Vari Hall', 'Near room 1004'),
('Glendon', 'York Hall', 'Outside Cafeteria entrance'), ('Glendon', 'Proctor Field House', 'By main entrance')
ON CONFLICT (building, location) DO NOTHING;
