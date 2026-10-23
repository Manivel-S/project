import { test, expect } from '@playwright/test';

test(
  'ModuleTest',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-050' },
    tag: ['@QADENCE_TC_ID:TC-050'],
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
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });

    await test.step('#08 - click', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });

    await test.step('#09 - click', async () => {
      await page.locator('[data-test="login-container"]').locator('[data-test="login-credentials-container"]').click();
    });
    //Start - Module - Module Logout

    await test.step.skip('#10 - Disabled - click', async () => {
      await page.locator('[data-test="login-container"]').locator('[data-test="login-credentials-container"]').click();
    });

    await test.step.skip('#11 - Disabled - click', async () => {
      await page.getByRole("button", { name: "Logout", exact: true }).click();
    });

    await test.step.skip('#12 - Disabled - logout', async () => {
      await page.getByRole("button", { name: "Open Menu", exact: true }).click();
    });
    //End - Module - Module Logout

  }
);

