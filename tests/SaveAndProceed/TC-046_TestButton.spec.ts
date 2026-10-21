import { test, expect } from '@playwright/test';

test(
  'TestButton',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-046' },
    tag: ['@QADENCE_TC_ID:TC-046'],
  },
  async ({ page, request }) => {


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

    await test.step('#10 - https://www.randomnumberapi.com/api/v1.0/random?min=1&max=100&count=1', async () => {
      const apiResponse10 = await request.fetch('https://www.randomnumberapi.com/api/v1.0/random?min=1&max=100&count=1', {
        method: 'GET',
      });
      expect(apiResponse10.status()).toBe(200);
    });
    //Start - Module - Module Logout

    await test.step('#11 - click', async () => {
      await page.locator('[data-test="login-container"]').locator('[data-test="login-credentials-container"]').click();
    });

    await test.step('#12 - click', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });

    await test.step('#13 - logout', async () => {
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });
    //End - Module - Module Logout

  }
);

