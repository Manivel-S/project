import { test, expect } from '@playwright/test';

test(
  'UnitTestSaveAndProceed',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-045' },
    tag: ['@QADENCE_TC_ID:TC-045'],
  },
  async ({ page }) => {

    //Start - Module - Login
    let header: any;
    let header2: any;


    await test.step('#01 - navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('#02 - get', async () => {
      header = await (new Function('page', 'locator', 'return (async () => {\n' + "return ''header" + '\n})();'))(page, undefined);
      header2 = await (new Function('page', 'locator', 'return (async () => {\n' + "return 'header2'" + '\n})();'))(page, undefined);
    });

    await test.step('#03 - click', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).click();
    });

    await test.step.skip('#04 - Disabled - fill', async () => {
      await page.getByRole("textbox", { name: "Username", exact: true }).fill('standard_user');
    });

    await test.step('#05 - click', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).click();
    });

    await test.step.skip('#06 - Disabled - fill', async () => {
      await page.getByRole("textbox", { name: "Password", exact: true }).fill('secret_sauce');
    });

    await test.step('#07 - get', async () => {
      // TODO: GET step has no variables
    });
    //End - Module - Login

    await test.step.skip('#08 - Disabled - navigate', async () => {
      await page.goto('https://www.saucedemo.com');
    });

    await test.step('#09 - click', async () => {
      await page.locator('[data-test="login-credentials-container"]').locator('[data-test="login-credentials"]').click();
    });

    await test.step('#10 - click', async () => {
      await page.locator('[data-test="login-credentials-container"]').locator('[data-test="login-password"]').click();
    });

    await test.step('#11 - click', async () => {
      await page.getByRole("main").filter({ hasText: "LoginAccepted usernames" }).click();
    });

  }
);

