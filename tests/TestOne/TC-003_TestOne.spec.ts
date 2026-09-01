import { test, expect } from '@playwright/test';

test(
  'TestOne',
  {
    annotation: { type: 'QADENCE_TC_ID', description: 'TC-003' },
    tag: ['@QADENCE_TC_ID:TC-003'],
  },
  async ({ page }) => {


    await test.step('navigate', async () => {
      await page.goto('https://www.saucedemo.com/');
    });

    await test.step('click', async () => {
      await page.locator('[data-test="username"]').click();
    });

//     await test.step('fill', async () => {
//       await page.locator('[data-test="username"]').fill('standard_user');
//     });

    await test.step('fill', async () => {
      await page.locator('[data="username"]').fill('standard_user');
    });

    await test.step('click', async () => {
      await page.locator('[data-test="password"]').click();
    });

    await test.step('fill', async () => {
      await page.locator('[data-test="password"]').fill('secret_sauce');
    });

    await test.step('click', async () => {
      await page.locator('[data-test="login-button"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="inventory-container"]').click();
    });

    await test.step('click', async () => {
      await page.locator("xpath=(//div)[25]").click();
    });

    await test.step('click', async () => {
      await page.getByText("$29.99", { exact: true }).click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="item-4-img-link"]').getByRole("img", { name: "Sauce Labs Backpack", exact: true }).click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="inventory-item"]').locator('[data-test="inventory-item-desc"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="inventory-item"]').locator('[data-test="inventory-item-name"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="inventory-item"]').getByRole("img", { name: "Sauce Labs Backpack", exact: true }).click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="back-to-products"]').click();
    });

    await test.step('click', async () => {
      await page.locator('[data-test="header-container"]').locator('[data-test="primary-header"]').click();
    });

  }
);

