const { Builder } = require ("selenium-webdriver");
const driver = new Builder().forBrowser("Firebox").build();

driver.get("http://localhost:3000");