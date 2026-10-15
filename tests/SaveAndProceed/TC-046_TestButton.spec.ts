import { test, expect } from '@playwright/test';

test(
  'TestButton',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-046' },
    tag: ['@QADENCE_TC_ID:TC-046'],
  },
  async ({ page }) => {


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - click', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

    await test.step('#03 - fill', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).fill('standard_user');
    });

    await test.step('#04 - click', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).click();
    });

    await test.step('#05 - fill', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).fill('secret_sauce');
    });

    await test.step('#06 - click', async () => {
      await page.getByRole("button", { name: "Login", exact: true }).click();
    });

    await test.step('#07 - click', async () => {
      await page.locator('[data-test="header-container"]').locator('[data-test="primary-header"]').click();
    });

    await test.step('#08 - click', async () => {
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });

    await test.step('#09 - click', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });
    //Start - Module - Login
    let header: any;
    let header2: any;


    await test.step('#10 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#11 - get', async () => {
      header = await (new Function('page', 'locator', 'return (async () => {\n' + "return ''header" + '\n})();'))(page, undefined);
      header2 = await (new Function('page', 'locator', 'return (async () => {\n' + "return 'header2'" + '\n})();'))(page, undefined);
    });

    await test.step.skip('#12 - Disabled - click', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

    await test.step.skip('#13 - Disabled - fill', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).fill('standard_user');
    });

    await test.step('#14 - click', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).click();
    });

    await test.step.skip('#15 - Disabled - fill', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).fill('secret_sauce');
    });

    await test.step('#16 - get', async () => {
      // TODO: GET step has no variables
    });
    //End - Module - Login

  }
);

